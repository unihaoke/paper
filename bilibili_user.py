# -*-coding:utf8-*-

import requests
import json
import random
import pymysql
import sys
import datetime
import time
from importlib import reload
from multiprocessing.dummy import Pool as ThreadPool

def datetime_to_timestamp_in_milliseconds(d):
    def current_milli_time(): return int(round(time.time() * 1000))

    return current_milli_time()


reload(sys)


def LoadUserAgents(uafile):
    uas = []
    with open(uafile, 'rb') as uaf:
        for ua in uaf.readlines():
            if ua:
                uas.append(ua.strip()[:-1])
    random.shuffle(uas)
    return uas


uas = LoadUserAgents("user_agents.txt")
head = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36',
    'X-Requested-With': 'XMLHttpRequest',
    'Referer': 'http://space.bilibili.com/45388',
    'Origin': 'http://space.bilibili.com',
    'Host': 'space.bilibili.com',
    'AlexaToolbar-ALX_NS_PH': 'AlexaToolbar/alx-4.0',
    'Accept-Language': 'zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4',
    'Accept': 'application/json, text/javascript, */*; q=0.01',
}

# Please replace your own proxies.
proxies = {
    'http': 'http://120.26.110.59:8080',
    'http': 'http://120.52.32.46:80',
    'http': 'http://218.85.133.62:80',
    'http': 'http://47.106.126.167:26480',
    'http': 'http://140.143.87.241:14428',
    'http': 'http://171.211.29.19:2311',
    'http': 'http://1.197.178.105:45277',
    'http': 'http://51.15.86.160:80',
    'http': 'http://40.77.23.128:3128',
    'http': 'http://119.23.23.50:80',
    'http': 'http://200.54.108.54:80',
    'http': 'http://177.72.1.102:8080',
    'http': 'http://182.16.171.18:53281',
    'http': 'http://123.138.89.133:9999',
    'http': 'http://79.129.56.159:8080',
    'http': 'http://194.183.137.18:3128',
    'http': 'http://118.98.123.18:53281',
    'http': 'http://223.85.196.75:9999',
    'http': 'http://41.78.243.241:53281',
    'http': 'http://160.202.42.195:80',
    'http': 'http://62.33.159.116:8080',

}
time1 = time.time()

urls = []

# Please change the range data by yourself.
for m in range(1, 150000):

    for i in range(m * 100, (m + 1) * 100):
        url = 'https://space.bilibili.com/' + str(i)
        urls.append(url)


    def getsource(url):
        payload = {
            '_': datetime_to_timestamp_in_milliseconds(datetime.datetime.now()),
            'mid': url.replace('https://space.bilibili.com/', '')
        }
        ua = random.choice(uas)
        head = {
            'User-Agent': ua,
            'Referer': 'https://space.bilibili.com/' + str(i) + '?from=search&seid=' + str(random.randint(10000, 50000))
        }
        jscontent = requests \
            .session() \
            .post('https://space.bilibili.com/ajax/member/GetInfo',
                  headers=head,
                  data=payload,
                  proxies=proxies) \
            .text
        time2 = time.time()
        try:
            jsDict = json.loads(jscontent)
            statusJson = jsDict['status'] if 'status' in jsDict.keys() else False
            if statusJson == True:
                if 'data' in jsDict.keys():
                    jsData = jsDict['data']
                    mid = jsData['mid']
                    name = jsData['name']
                    sex = jsData['sex']
                    rank = jsData['rank']
                    face = jsData['face']
                    regtimestamp = jsData['regtime']
                    regtime_local = time.localtime(regtimestamp)
                    regtime = time.strftime("%Y-%m-%d %H:%M:%S",regtime_local)
                    spacesta = jsData['spacesta']
                    birthday = jsData['birthday'] if 'birthday' in jsData.keys() else 'nobirthday'
                    sign = jsData['sign']
                    level = jsData['level_info']['current_level']
                    OfficialVerifyType = jsData['official_verify']['type']
                    OfficialVerifyDesc = jsData['official_verify']['desc']
                    vipType = jsData['vip']['vipType']
                    vipStatus = jsData['vip']['vipStatus']
                    toutu = jsData['toutu']
                    toutuId = jsData['toutuId']
                    coins = jsData['coins']
                    print("Succeed get user info: " + str(mid) + "\t" + str(time2 - time1))
                    try:
                        res = requests.get(
                            'https://api.bilibili.com/x/relation/stat?vmid=' + str(mid) + '&jsonp=jsonp').text
                        viewinfo = requests.get(
                            'https://api.bilibili.com/x/space/upstat?mid=' + str(mid) + '&jsonp=jsonp').text
                        js_fans_data = json.loads(res)
                        js_viewdata = json.loads(viewinfo)
                        following = js_fans_data['data']['following']
                        fans = js_fans_data['data']['follower']
                        archiveview = js_viewdata['data']['archive']['view']
                        article = js_viewdata['data']['article']['view']
                    except:
                        following = 0
                        fans = 0
                        archiveview = 0
                        article = 0
                else:
                    print('no data now')
                try:
                    # Please write your MySQL's information.
                    conn = pymysql.connect(
                        host='localhost', user='root', passwd='tiger', db='bilibili', charset='utf8')
                    cur = conn.cursor()
                    cur.execute('INSERT INTO bilibili_user_info(mid, name, sex, rank, face, regtime, spacesta, \
                                birthday, sign, level, OfficialVerifyType, OfficialVerifyDesc, vipType, vipStatus, \
                                toutu, toutuId, coins, following, fans ,archiveview, article) \
                    VALUES ("%s","%s","%s","%s","%s","%s","%s","%s","%s","%s",\
                            "%s","%s","%s","%s","%s", "%s","%s","%s","%s","%s","%s")'
                                %
                                (mid, name, sex, rank, face, regtime, spacesta, \
                                birthday, sign, level, OfficialVerifyType, OfficialVerifyDesc, vipType, vipStatus, \
                                toutu, toutuId, coins, following, fans ,archiveview, article))
                    conn.commit()
                except Exception as e:
                    print(e)
            else:
                print("Error: " + url)
        except Exception as e:
            print(e)
            pass

if __name__ == "__main__":
    pool = ThreadPool(1)
    try:
        results = pool.map(getsource, urls)
    except Exception as e:
        print(e)
 
    pool.close()
    pool.join()



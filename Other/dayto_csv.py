from datetime import datetime, timedelta
import requests
import json
import pandas as pd
import csv
#FisheryProductsTransType 1040601
#AgriProductsTransType 104.01.01


stop_day="1040601"
ymd=""
n=1
while ymd!=stop_day:
    d = datetime.today() - timedelta(days=n)
    n=n+1
    year=(d.year-1911)
    month=(d.month)
    day=(d.day)
    ymd=f"{year:03d}.{month:02d}.{day:02d}"
    ymd2=f"{year:03d}{month:02d}{day:02d}"
    print(ymd)
    url = f"https://data.coa.gov.tw/api/v1/FisheryProductsTransType/?Start_time={ymd2}&End_time={ymd2}"
    response = requests.request("GET", url).json()
    df = pd.DataFrame(response['Data'])
    df.to_csv(f'FisheryProductsTransType{ymd2}.csv')
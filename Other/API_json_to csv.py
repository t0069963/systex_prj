import requests
import json
import pandas as pd
import csv





url = "https://data.coa.gov.tw/api/v1/SeafoodProdMarketType/"
response = requests.request("GET", url).json()
df = pd.DataFrame(response['Data'])
df.to_csv('response_python.csv')

import requests
from utils import geo

def get_all_ewaste_locations():
          
    dataset_id = "d_e8c94e00d7e1dca4ae3248d0a8e39959"
    url = "https://api-open.data.gov.sg/v1/public/api/datasets/" + dataset_id + "/poll-download"
            
    response = requests.get(url)
    json_data = response.json()
    if json_data['code'] != 0:
        print(json_data['errMsg'])
        exit(1)

    url = json_data['data']['url']
    response = requests.get(url)
    return response.text

def get_ewaste_locations_nearby(lat, lng, radius_km):
    ewaste_locations = get_all_ewaste_locations()
    # filter the bins using geo.is_within_radius(lat1, lng1, lat2, lng2, radius_km)
    pass

from fastapi import APIRouter
from fastapi import Query
from services import ewaste, recycling_bins, salvation_army, vape_bins

router = APIRouter()

@router.get("/locations/all")
def get_all_locations():
    return {
        "e_waste": ewaste.get_ewaste_locations(),
        "recycling": recycling_bins.get_recycling_locations(),
        "donation": salvation_army.get_salvation_army_locations(),
        "vape_bins": vape_bins.get_vape_locations()
    }

@router.get("/locations/ewaste-all")
def get_ewaste_locations():
    return {
        "e_waste": ewaste.get_all_ewaste_locations()
    }

@router.get("/locations/ewaste-near-user")
def get_nearby_ewaste_bins(lat: float = Query(...), lng: float = Query(...), radius_km: float = 1.0):
    return ewaste.get_ewaste_locations_nearby(lat, lng, radius_km)

# we probably need to decide on more routes for the other APIs and the scraped data
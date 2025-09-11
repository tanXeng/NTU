from math import radians, sin, cos, sqrt, atan2

def is_within_radius(lat1, lng1, lat2, lng2, radius_km):
    # use this as reference: https://en.wikipedia.org/wiki/Haversine_formula
    R = 6371  # Earth radius
    dlat = radians(lat2 - lat1)
    dlng = radians(lng2 - lng1)
    a = sin(dlat / 2)**2 + cos(radians(lat1)) * cos(radians(lat2)) * sin(dlng / 2)**2
    c = 2 * atan2(sqrt(a), sqrt(1 - a))
    distance = R * c
    return distance <= radius_km

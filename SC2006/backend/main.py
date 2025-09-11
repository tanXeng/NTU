from fastapi import FastAPI
from routers import locations

app = FastAPI()

app.include_router(locations.router, prefix="/api")
package responses;

import services.Log;

class ResponseBuildLogger {
    void logBuilding(String requestType, String responseFileName, String endPoint) {
        Log.info(" Building '" + requestType + "' response with body from file '" + responseFileName + "' for endpoint: " + endPoint);
    }
}

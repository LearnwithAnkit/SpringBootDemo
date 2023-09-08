package com.ticketapi.TicketManagementApp;

import com.ticketapi.TicketManagementApp.entity.Ticket;
import org.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class CustomResponse {

    public static JSONObject setResponse(String status, Object ob, String message, String objectName) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);

        if (ob != null) {
            jsonObject.put(objectName, toJson(ob));
        } else {
            jsonObject.put("message", message);
        }

        return jsonObject;
    }

    public static JSONObject setResponse(String status, String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", message);
        return jsonObject;
    }

    private static String toJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}

package com.example.articulate.constant;

public interface Constants {
    interface API {
        String API_PREFIX = "/api";
    }

    interface Default {
        int MAX_USERNAME_LENGTH = 25;
        int DB_MAX_LENGTH = 255;
    }

    interface Regex {
        String SA_PHONE_NUMBER = "^5[0-9]{8}$";
    }

    interface ErrorMessages {
        String USERNAME_USED = "the username is already used";
        String EMAIL_USED = "the email is already used";
        String PHONE_NUMBER_USED = "the phone number is already used";
        String PHONE_NUMBER_INVALID = "phone number must be entered correctly, (5XXXXXXXX)";
        String GENERIC_SERVER_ERROR = "an unexpected error occurred";

    }

    interface CacheKeys {
        String PRIVILEGE_CACHE_KEY="PRIVILEGE_CACHE_KEY";
    }
}

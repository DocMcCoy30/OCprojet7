package com.dmc30.clientui.exception;

public enum ErrorMessage {

    SQL_SYNTAX_ERROR(100, "Une erreur de type SQL est survenue.", "Vérifier la requète SQL ou la structure de la table"),
    SQL_QUERY_ERROR(101, "Un problème est survenu lors de la récupération des données", "Vérifier la connexion à la base de données ou la requète SQL"),
    SQL_UPDATE_ERROR(102, "Un problème est survenu lors de la création des données", "Vérifier la connexion à la base de données ou la requète SQL"),
    SQL_DELETE_ERROR(103, "Un problème est survenu lors de la suppression des données", "Vérifier la connexion à la base de données ou la requète SQL"),

    TX_ERROR(200, "Une erreur technique est survenue lors de la création du compte.", "Une erreur est survenue lors de l'execution de la transaction"),

    DUPLICATE_KEY_ERROR(300, "Ce username/mail existe déjà dans la base", "Username ou mail déjà existant dans la base de données"),

    TECHNICAL_ERROR(400, "Une erreur technique est survenue.", "Une erreur technique est survenue."),
    BAD_CREDENTIAL_ERROR(401, "Adresse email ou mot de passe erronés", "Identification impossible" ),
    TOKEN_EXPIRED_OR_INVALID(498, "Le jeton a expiré ou est invalide", "Le jeton a expiré ou est invalide");

    private Integer errorCode;
    private String errorMessage;
    private String errorDescription;

    ErrorMessage(int errorCode, String errorMessage, String errorDescription) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}

package com.dmc30.empruntservice.web.exception;

public enum ErrorMessage {

    SQL_SYNTAX_ERROR(460, "Une erreur de type SQL est survenue.", "Vérifier la requète SQL ou la structure de la table"),
    SQL_QUERY_ERROR(461, "Un problème est survenu lors de la récupération des données", "Vérifier la connexion à la base de données ou la requète SQL"),
    SQL_UPDATE_ERROR(462, "Un problème est survenu lors de la création des données", "Vérifier la connexion à la base de données ou la requète SQL"),
    SQL_DELETE_ERROR(463, "Un problème est survenu lors de la suppression des données", "Vérifier la connexion à la base de données ou la requète SQL"),

    TX_ERROR(470, "Une erreur technique est survenue lors de la création du compte.", "Une erreur est survenue lors de l'execution de la transaction"),

    DUPLICATE_KEY_ERROR(480, "Ce username/mail existe déjà dans la base", "Username ou mail déjà existant dans la base de données"),
    BAD_CREDENTIAL_ERROR(481, "Adresse email ou mot de passe erronés", "Identification impossible" ),
    TOKEN_EXPIRED_OR_INVALID(482, "Le jeton a expiré ou est invalide", "Le jeton a expiré ou est invalide"),

    TECHNICAL_ERROR(490, "Une erreur technique est survenue.", "Une erreur technique est survenue."),
    INTROUVABLE_EXCEPTION(491,"La ressource demandée est introuvable", "IllegalArgumentException : l'argument passé en paramètre n'est pas référencé dans la base de données");

    private final Integer errorCode;
    private final String errorMessage;
    private final String errorDescription;

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

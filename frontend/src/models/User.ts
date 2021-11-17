export class User {

    id: string;

    displayName: string;

    givenName: string;

    jobTitle: string;

    mail: string;

    mobilePhone: string;

    officeLocation: string;

    preferredLanguage: string;

    surname: string;

    userPrincipalName: string;


    constructor(id: string, displayName: string, givenName: string, jobTitle: string, mail: string, mobilePhone: string, officeLocation: string, preferredLanguage: string, surname: string, userPrincipalName: string,) {
        this.id = id; 
        this.displayName = displayName; 
        this.givenName = givenName; 
        this.jobTitle = jobTitle; 
        this.mail = mail; 
        this.mobilePhone = mobilePhone; 
        this.officeLocation = officeLocation; 
        this.preferredLanguage = preferredLanguage; 
        this.surname = surname; 
        this.userPrincipalName  = userPrincipalName; 
    }
}
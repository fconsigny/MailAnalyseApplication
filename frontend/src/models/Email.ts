export class Email {

    id: string;

    internetMessageId: string;

    createdDateTime: string;

    lastModifiedDateTime: string;

    receivedDateTime: string;

    sendDateTime: string;

    hasAttachments: Boolean;

    subject: string;

    bodyPreview: string;

    isRead: Boolean;

    webLink: string;

    senderEmailAddress: string;

    fromEmailAddress: string;

    constructor(id: string, internetMessageId: string, createdDateTime: string, lastModifiedDateTime: string, receivedDateTime: string, sendDateTime: string, hasAttachments: Boolean, subject: string, bodyPreview: string, isRead: Boolean, webLink: string, senderEmailAddress: string, fromEmailAddress: string) {
        this.id = id;

        this.internetMessageId = internetMessageId;

        this.createdDateTime = createdDateTime;

        this.lastModifiedDateTime = lastModifiedDateTime;

        this.receivedDateTime = receivedDateTime;

        this.sendDateTime = sendDateTime;

        this.hasAttachments = hasAttachments;

        this.subject = subject;

        this.bodyPreview = bodyPreview;

        this.isRead = isRead;

        this.webLink = webLink;

        this.senderEmailAddress = senderEmailAddress;

        this.fromEmailAddress = fromEmailAddress;
    }
}
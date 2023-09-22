package com.example.Instagrambackend.DTO;


public class SenderIdReceiverDTO {

    private Long sender;

    private Long receiver;

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }
}

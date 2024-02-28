package com.example.Instagrambackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SenderIdReceiverDTO {

    private Long sender;
    private Long receiver;
    private String action;
    private String request;

}

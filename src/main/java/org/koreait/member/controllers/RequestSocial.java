package org.koreait.member.controllers;

import lombok.Data;
import org.koreait.member.social.constants.SocialType;

@Data
public class RequestSocial {
    private SocialType socialType;
    private String socialToken;
}

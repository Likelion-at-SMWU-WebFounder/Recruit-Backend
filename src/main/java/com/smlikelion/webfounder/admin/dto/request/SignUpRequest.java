package com.smlikelion.webfounder.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class SignUpRequest {
    @NotNull(message = "아이디 입력을 해야 합니다.")
    private String accountId;

    @NotNull(message = "비밀번호 입력을 해야 합니다.")
    private String password;

    @NotNull(message = "이름 입력을 해야 합니다.")
    private String name;

}

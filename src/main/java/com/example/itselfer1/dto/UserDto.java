package com.example.itselfer1.dto;

import com.example.itselfer1.domain.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private Long idx;
    private String vName;
    private String vPhone;
    private String vPwd;
    private String fUse;
    private String fGrade;
    private String vMembershipNo;
    private String fJoinChannel;
    private String vRemainDate;
    private String vApproveStatus;
    private String vCreateId;

    public UserEntity toEntity() {
        UserEntity build = UserEntity.builder()
                .idx(idx)
                .vName(vName)
                .vPhone(vPhone)
                .vPwd(vPwd)
                .fUse(fUse)
                .fGrade(fGrade)
                .vMembershipNo(vMembershipNo)
                .fJoinChannel(fJoinChannel)
                .vRemainDate(vRemainDate)
                .vApproveStatus(vApproveStatus)
                .vCreateId(vCreateId)
                .build();

        return build;
    }

    @Builder
    public UserDto(Long idx, String vName, String vPhone, String vPwd, String fUse, String fGrade, String vMembershipNo, String fJoinChannel, String vRemainDate, String vApproveStatus, String vCreateId) {
        this.idx = idx;
        this.vName = vName;
        this.vPhone = vPhone;
        this.vPwd = vPwd;
        this.fUse = fUse;
        this.fGrade = fGrade;
        this.vMembershipNo = vMembershipNo;
        this.fJoinChannel = fJoinChannel;
        this.vRemainDate = vRemainDate;
        this.vApproveStatus = vApproveStatus;
        this.vCreateId = vCreateId;

    }

}

package com.example.itselfer1.domain.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Entity
@Table(name="muserstb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends TimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDX")
    private Long idx;

    @Column(name="V_NAME")
    private String vName;

    @Column(name="V_PHONE")
    private String vPhone;

    @Column(name="V_PWD")
    private String vPwd;

    @Column(name="F_USE")
    @ColumnDefault("0")
    private String fUse;

    @Column(name="F_GRADE")
    @ColumnDefault("1")
    private String fGrade;

    @Column(name="V_MEMBETSHOP_NO")
    private String vMembershipNo;

    @Column(name="F_JOIN_CHANNEL")
    private String fJoinChannel;

    @Column(name="V_REMAIN_DATE")
    private String vRemainDate;

    @Column(name="V_APPROVE_STATUS")
    private String vApproveStatus;

    @Column(name="V_CREATE_ID")
    private String vCreateId;


    @Builder
    public UserEntity(Long idx, String vName, String vPhone, String vPwd, String fUse, String fGrade, String vMembershipNo, String fJoinChannel, String vRemainDate, String vApproveStatus, String vCreateId) {
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

package com.gae4coon.cloudmaestro.domain.mypage.entity;


import com.gae4coon.cloudmaestro.domain.user.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "diagram")

public class Diagram{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagram_id", nullable = false, length = 256)
    private Long diagramId;

    // AWS와 User는 ManyToOne 관계임을 명시
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member userId;

    @Column(name = "diagram_file", nullable = false, length = 256)
    private String diagramFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "require_id")
    private Require require;

    @Builder
    public Diagram(Long diagramId, Member userId, String diagramFile, Require require){
        this.diagramId = diagramId;
        this.userId = userId;
        this.diagramFile = diagramFile;
        this.require = require;
    }

}

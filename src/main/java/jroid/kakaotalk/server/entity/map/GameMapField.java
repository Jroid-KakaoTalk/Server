package jroid.kakaotalk.server.entity.map;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameMapField {
    
    @Id
    @Column
    Integer fieldLocation;
    
    @Column(columnDefinition = "SMALLINT UNSIGNED")
    Integer arriveEvent;
    
    @Column(columnDefinition = "BIGINT UNSIGNED")
    BigInteger money;
    
    @ManyToOne
    @JoinColumn(name = "location", nullable = false)
    GameMap gameMap;
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.gameMapField", cascade = CascadeType.ALL)
    List<GameMapFieldItem> gameMapFieldItemList = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "pk.gameMapField", cascade = CascadeType.ALL)
    List<GameMapFieldLivingEquip> gameMapFieldLivingEquipList = new ArrayList<>();
    
}
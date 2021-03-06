package jroid.kakaotalk.server.entity.player;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerTitle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    
    @Column(nullable = false, length = 63)
    String title;
    
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    Player player;
    
}
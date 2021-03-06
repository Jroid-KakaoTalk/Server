package jroid.kakaotalk.server.entity.npc;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NpcChatLimitIntimacyPk implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "npc_chat_id")
    NpcChat npcChat;
    
    @ManyToOne
    @JoinColumn(name = "npc_id")
    Npc npc;
    
    @Override
    public int hashCode() {
        return npcChat.id.hashCode() ^ npc.id.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(obj instanceof NpcChatLimitIntimacyPk) {
            NpcChatLimitIntimacyPk pk = (NpcChatLimitIntimacyPk) obj;
            return npcChat.id.equals(pk.npcChat.id) &&
                npc.id.equals(pk.npc.id);
        } else {
            return false;
        }
    }
    
}
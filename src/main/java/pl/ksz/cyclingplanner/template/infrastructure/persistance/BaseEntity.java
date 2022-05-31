package pl.ksz.cyclingplanner.template.infrastructure.persistance;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.AbstractAuditable;
import pl.ksz.cyclingplanner.template.infrastructure.security.AthleteEntity;

@MappedSuperclass
@TypeDef(name = "json", typeClass = JsonType.class)
public class BaseEntity extends AbstractAuditable<AthleteEntity, UUID> {

    @Version
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


}

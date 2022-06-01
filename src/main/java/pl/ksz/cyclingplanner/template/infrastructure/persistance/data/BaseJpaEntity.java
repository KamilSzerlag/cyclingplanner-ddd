package pl.ksz.cyclingplanner.template.infrastructure.persistance.data;

import com.vladmihalcea.hibernate.type.json.JsonType;
import java.util.UUID;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@MappedSuperclass
@TypeDef(name = "json", typeClass = JsonType.class)
public class BaseJpaEntity extends AbstractPersistable<UUID> {

    @Version
    private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


}

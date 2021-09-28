package dabang;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InfomationRepository extends CrudRepository<Infomation, Long> {

    List<Infomation> findByContractId(Long contractId);


}
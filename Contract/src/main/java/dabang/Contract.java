package dabang;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Contract_table")
public class Contract {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long contractId;
    private Double deposit;
    private String status;

    @PostPersist
    public void onPostPersist(){

        String location = System.getenv("LOCATION");
        if(location == null) location = "LOCAL";
        System.out.println("######################################################################################");
        System.out.println("#################################ConfigMap############################################");
        System.out.println("######################################################################################");
        System.out.println("######################################################################################");
        System.out.println("########################CURRENT_LOCATION = "+location+"###############################");
        System.out.println("######################################################################################");
        System.out.println("######################################################################################");
        System.out.println("#################################ConfigMap############################################");
        System.out.println("######################################################################################");

        Contracted contracted = new Contracted();
        BeanUtils.copyProperties(this, contracted);
        contracted.setStatus("Contracted");
        contracted.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        dabang.external.Pay pay = new dabang.external.Pay();
        // mappings goes here
        pay.setContractId(this.contractId);
        pay.setStatus("Contracted");
        pay.setDeposit(this.deposit);
        ContractApplication.applicationContext.getBean(dabang.external.PayService.class)
            .payment(pay);

      

    }

    @PostUpdate
    public void onPostUpdate(){
        Contractcanceled contractcanceled = new Contractcanceled();
        BeanUtils.copyProperties(this, contractcanceled);
        contractcanceled.publishAfterCommit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
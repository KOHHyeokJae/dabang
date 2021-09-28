package dabang;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Infomation_table")
public class Infomation {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long contractId;
        private String contractstatus;
        private String paystatus;
        private String reservationstatus;


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
        public String getContractstatus() {
            return contractstatus;
        }

        public void setContractstatus(String contractstatus) {
            this.contractstatus = contractstatus;
        }
        public String getPaystatus() {
            return paystatus;
        }

        public void setPaystatus(String paystatus) {
            this.paystatus = paystatus;
        }
        public String getReservationstatus() {
            return reservationstatus;
        }

        public void setReservationstatus(String reservationstatus) {
            this.reservationstatus = reservationstatus;
        }

}
package dabang;

import dabang.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired PayRepository payRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceld_Paymentcancel(@Payload ReservationCanceld reservationCanceld){

        if(!reservationCanceld.validate()) return;

        System.out.println("\n\n##### listener Paymentcancel : " + reservationCanceld.toJson() + "\n\n");



        // Sample Logic //
        // Pay pay = new Pay();
        // payRepository.save(pay);
        Pay pay = payRepository.findByContractId(reservationCanceld.getContractId());
        pay.setStatus("Payment Canceled");
        payRepository.save(pay);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
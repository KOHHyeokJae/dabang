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

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_Kakaotalk(@Payload Reserved reserved){

        if(!reserved.validate()) return;

        System.out.println("\n\n##### listener Kakaotalk : " + reserved.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_Kakaotalk(@Payload Paid paid){

        if(!paid.validate()) return;

        System.out.println("\n\n##### listener Kakaotalk : " + paid.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCanceled_Kakaotalk(@Payload PaymentCanceled paymentCanceled){

        if(!paymentCanceled.validate()) return;

        System.out.println("\n\n##### listener Kakaotalk : " + paymentCanceled.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverContracted_Kakaotalk(@Payload Contracted contracted){

        if(!contracted.validate()) return;

        System.out.println("\n\n##### listener Kakaotalk : " + contracted.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverContractcanceled_Kakaotalk(@Payload Contractcanceled contractcanceled){

        if(!contractcanceled.validate()) return;

        System.out.println("\n\n##### listener Kakaotalk : " + contractcanceled.toJson() + "\n\n");



        // Sample Logic //

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceld_Kakaotalk(@Payload ReservationCanceld reservationCanceld){

        if(!reservationCanceld.validate()) return;

        System.out.println("\n\n##### listener Kakaotalk : " + reservationCanceld.toJson() + "\n\n");



        // Sample Logic //

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
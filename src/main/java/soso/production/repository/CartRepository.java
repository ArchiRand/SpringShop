package soso.production.repository;

import soso.production.model.Cart;
import soso.production.model.dto.CartReportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByCartOwner_Email(String email);

    @Query("Select new soso.production.model.dto.CartReportDto(cart.id, cart.date, cart.fullPrice, user.email, user.phone.number)" +
            "from Cart cart join cart.cartOwner user order by cart.date desc")
    List<CartReportDto> findAllCartReports();

    @Query("Select new soso.production.model.dto.CartReportDto(cart.id, cart.date, cart.fullPrice, user.email, user.phone.number)" +
            "from Cart cart join cart.cartOwner user where cart.id=:id")
    CartReportDto findCartReportByCartId(@Param("id") Long id);
}

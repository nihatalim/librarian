package tr.com.nihatalim.librarian.infra.checkout.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tr.com.nihatalim.librarian.infra.checkout.persistence.entity.CheckoutEntity;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {
    @Query(value = "select ce from CheckoutEntity ce where ce.bookId=?1 order by ce.checkoutDate desc limit 1", nativeQuery = true)
    CheckoutEntity getLastCheckout(Long bookId);
}

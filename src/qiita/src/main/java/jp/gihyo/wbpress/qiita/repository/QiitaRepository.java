package jp.gihyo.wbpress.qiita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.gihyo.wbpress.qiita.domain.QiitaItem;

@Repository // (d1)
public interface QiitaRepository extends JpaRepository<QiitaItem, String> {
}

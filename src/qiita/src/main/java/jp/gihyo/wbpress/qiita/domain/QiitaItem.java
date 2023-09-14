package jp.gihyo.wbpress.qiita.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // (d1)
@Table(name = "item") // (d2)
@Data // (d3)
@NoArgsConstructor // (d4)
@AllArgsConstructor // (d5)
@JsonIgnoreProperties( // (d6)
		ignoreUnknown = true)
public class QiitaItem {

	@Id
	String id;

	String title;

	String url;

	@JsonProperty("created_at") // (d7)
	String createTime;

	@JsonProperty("updated_at")
	String updateTime;

}

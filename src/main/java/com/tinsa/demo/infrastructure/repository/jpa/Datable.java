package com.tinsa.demo.infrastructure.repository.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@MappedSuperclass
public class Datable {
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENABLED_DATE")
	private Date enabledDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_MODIFIED_DATE")
	private Date lastModifiedDate;
	
	 public Datable()
	  {
	    // default constructor
	  }

	  public Date getEnabledDate()
	  {
	    return new Date(enabledDate.getTime());
	  }

	  public void setEnabledDate(Date enabledDate)
	  {
	    this.enabledDate = new Date(enabledDate.getTime());
	  }

	  public Date getLastModifiedDate()
	  {
	    return new Date(lastModifiedDate.getTime());
	  }

	  public void setLastModifiedDate(Date lastModifiedDate)
	  {
	    this.lastModifiedDate = new Date(lastModifiedDate.getTime());
	  }
	  
	  @PrePersist
	  public void onPersist ()
	  {
	    setLastModifiedDate(new Date());
	    setEnabledDate(new Date());
	  }

	  @PreUpdate
	  public void onUpdate ()
	  {
	    setLastModifiedDate(new Date());
	  }
}

package com.epam.jjp.sjspt.factory;

import org.springframework.beans.factory.FactoryBean;

import com.epam.jjp.sjspt.domain.BlastGun;

public class BlastGunFactory implements FactoryBean<BlastGun> {
	private final int damageRange;
	
	
	public BlastGunFactory(final int damageRange) {
		this.damageRange = damageRange;
	}

	public BlastGun getObject() throws Exception {
		String name = "BlastGun #"+ System.nanoTime();
		int damage = (int) (Math.random() * damageRange);
		return new BlastGun(name,damage);
	}


	public Class<?> getObjectType() {
		return BlastGun.class;
	}


	public boolean isSingleton() {
		return false;
	}



}

package com.epam.jjp.sjspt.factory;

import org.springframework.stereotype.Component;

import com.epam.jjp.sjspt.domain.Battlefield;
@Component
public abstract class BattlefieldFactory {

	public abstract Battlefield createBattlefield();

}
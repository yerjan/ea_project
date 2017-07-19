package edu.mum.dao;

import java.util.Date;

import edu.mum.domain.Balance;

public interface BalanceDao extends GenericDao<Balance> {

	public Balance findActiveBalance(Long accountId);

	public Balance findByAccountWithDate(Long accountId, Date valueDate);

	public Balance updateBalanceStatus(Long accountId);
}

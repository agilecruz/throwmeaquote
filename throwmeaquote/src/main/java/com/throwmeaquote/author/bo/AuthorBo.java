package com.throwmeaquote.author.bo;

public interface AuthorBo {
	AuthorBo findById(Long id);

	void save(AuthorBo author);

	void delete(AuthorBo author);
}

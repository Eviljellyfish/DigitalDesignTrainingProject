package com.kashigin.stanislav.dto.map;

public interface Mapper<M, Dto> {
    public Dto convertToDto(M m);

    public M convertToModel(Dto dto);
}

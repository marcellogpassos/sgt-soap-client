package br.jus.tjpb.libs.sgtsoapcient.client;

public interface IConverter<T, R> {

    R convert(T input);
}

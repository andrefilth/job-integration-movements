package br.com.cea.transporte.batch;

import org.apache.commons.lang3.StringUtils;

public class TesteSubString {
	public static void main(String[] args) {

		String linha = "0000000001 00123201710101307 01 0000001000000100000100000000000000000000";
//		String last = StringUtils.substringBetween(string, "|");
		String item = StringUtils.substring(linha, 1, 10);
		String qta = StringUtils.substring(linha, 29, 31);
		System.out.println("Item: " + item + "  Quantidade: " + qta);
//		StringUtils.substringBeforeLast("abcba", "b") = "abc";
	}
}

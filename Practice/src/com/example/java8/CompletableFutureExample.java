package com.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		
		Map<By,String> map = null;
		
		List<String> webPageLinks = Arrays.asList("url1","url2","url3");// A list of 100 web page links

				// Download contents of all the web pages asynchronously
				List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
				        .map(webPageLink -> downloadWebPage(webPageLink))
				        .collect(Collectors.toList());


				// Create a combined Future using allOf()
				CompletableFuture<Void> allFutures = CompletableFuture.allOf(
				        pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()])
				);
				
				// When all the Futures are completed, call `future.join()` to get their results and collect the results in a list -
				CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
				   return pageContentFutures.stream()
				           .map(pageContentFuture -> pageContentFuture.join())
				           .collect(Collectors.toList());
				});
				
				System.out.println(allPageContentsFuture.get());
				
				// Count the number of web pages having the "CompletableFuture" keyword.
				CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
				    return pageContents.stream()
				            .filter(pageContent -> pageContent.contains("abc"))
				            .count();
				});

				System.out.println("Number of Web Pages having CompletableFuture keyword - " + 
				        countFuture.get());
	}

	static CompletableFuture<String> downloadWebPage(String pageLink) {
		return CompletableFuture.supplyAsync(() -> {
			return System.currentTimeMillis() % 2 == 0 ? "abc" : "abcd";
		});
	}
}

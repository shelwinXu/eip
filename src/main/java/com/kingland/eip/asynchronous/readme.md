### Day06 Asynchronous Programming Using CompletionStage
* 1.定义图书的实体类Book（字段有id，name，score）
* 2.调用一个API获取图书列表返回值为ComplationStage<List<Book>>
* 3.再调用一个API获取图书的评分（score），参数为book的id，返回值为CompletionStage<Double>，此API会传入一个bookId然后返回当前book的score，可以使用map来模拟。
* 4.利用CompletionStage/CompletableFuture把图书的评分填充到对应的图书列表里。最后将填充后的Book列表进行打印。
注意：（因为没有对应的API，可以只定义方法然后把数据返回）
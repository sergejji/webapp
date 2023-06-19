<!DOCTYPE html>
<html>
<head>
  <title>Sales</title>
  <link rel="stylesheet" href="static/css/style.css">
</head>
<body>
  <h1>Sales</h1>
  <table border="1">
    <thead>
      <tr>
        <th>ID</th>
        <th>Product ID</th>
        <th>Buyer ID</th>
      </tr>
    </thead>
    <tbody>
    <#list sales as sale>
      <tr>
        <td>${sale.sale_id}</td>
        <td><a href="/products">${sale.product}</a></td>
        <td><a href="/buyers">${sale.buyer}</a></td>
        <td>
            <form action="/obrisiii/${sale.sale_id}" method="POST">
              <button type="submit">Obrisi</button>
            </form>
        </td>
        <td>
            <form action="/urediii/${sale.sale_id}" method="POST">
               <label for="product_id">Product ID:</label>
                <input type="number" id="product_id" name="product_id" required>
                <label for="buyer_id">Buyer ID:</label>
                <input type="number" id="buyer_id" name="buyer_id" required>
              <button type="submit">Azuriraj</button>
            </form>
        </td>
      </tr>
    </#list>
    </tbody>
  </table>
  <h2>Dodaj prodaju</h2>
  <form action="/sacuvajjj" method="POST">
    <label for="product_id">Product ID:</label>
    <input type="number" id="product_id" name="product_id" required>
    <label for="buyer_id">Buyer ID:</label>
    <input type="number" id="buyer_id" name="buyer_id" required>
    <button type="submit">Dodaj</button>
  </form>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
  <title>Products</title>
  <link rel="stylesheet" href="static/css/style.css">
</head>
<body>
  <h1>Products</h1>
  <table border="1">
    <thead>
      <tr>
        <th>ID</th>
        <th>Ime</th>
        <th>Cena</th>
      </tr>
    </thead>
    <tbody>
    <#list products as product>
      <tr>
        <td>${product.product_id}</td>
        <td>${product.product_name}</td>
        <td>${product.product_price}</td>
        <td>
            <form action="/obrisi/${product.product_id}" method="POST">
              <button type="submit">Obrisi</button>
            </form>
        </td>
        <td>
            <form action="/uredi/${product.product_id}" method="POST">
              <input type="hidden" name="id" value="${product.product_id}">
              <label for="name">Novo ime:</label>
              <input type="text" id="name" name="name" required>
              <label for="price">Nova cena:</label>
              <input type="number" id="price" name="price" required>
              <button type="submit">Azuriraj</button>
            </form>
          </td>
      </tr>
      </#list>
    </tbody>
  </table>
  <h2>Dodaj novi proizvod</h2>
  <form action="/sacuvaj" method="POST">
    <label for="name">Naziv:</label>
    <input type="text" id="name" name="name" required>
    <label for="price">Cena:</label>
    <input type="number" id="price" name="price" required>
    <button type="submit">Dodaj</button>
  </form>
  <a href="/sales">Sales strana</a>
</body>
</html>

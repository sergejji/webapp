<!DOCTYPE html>
<html>
<head>
  <title>Buyers</title>
  <link rel="stylesheet" href="static/css/style.css">
</head>
<body>
  <h1>Buyers</h1>
  <table border="1">
    <thead>
      <tr>
        <th>ID</th>
        <th>Ime</th>
        <th>Prezime</th>
        <th>Email</th>
        <th>Adresa</th>
      </tr>
    </thead>
    <tbody>
      <#list buyers as buyer>
        <tr>
          <td>${buyer.buyer_id}</td>
          <td>${buyer.first_name}</td>
          <td>${buyer.last_name}</td>
          <td>${buyer.email}</td>
          <td>${buyer.address}</td>
          <td>
            <form action="/obrisii/${buyer.buyer_id}" method="POST">
              <button type="submit">Obrisi</button>
            </form>
            <form action="/uredii/${buyer.buyer_id}" method="POST">
              <input type="hidden" name="id" value="${buyer.buyer_id}">
              <label for="first_name">Novo ime:</label>
              <input type="text" id="first_name" name="first_name" required>
              <label for="last_name">Novo prezime:</label>
              <input type="text" id="last_name" name="last_name" required>
              <label for="email">Novi email:</label>
              <input type="email" id="email" name="email" required>
              <label for="address">Nova adresa:</label>
              <input type="text" id="address" name="address" required>
              <button type="submit">Azuriraj</button>
            </form>
          </td>
        </tr>
      </#list>
    </tbody>
  </table>
  <h2>Dodaj novog kupca</h2>
  <form action="/sacuvajj "method="POST">
    <label for="first_name">Ime:</label>
    <input type="text" id="first_name" name="first_name" required>
    <label for="last_name">Prezime:</label>
    <input type="text" id="last_name" name="last_name" required>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    <label for="address">Adresa:</label>
    <input type="text" id="address" name="address" required>
    <button type="submit">Dodaj</button>
  </form>
  <a href="/sales">Sales strana</a>
</body>
</html>

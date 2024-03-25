let cacheName = "v1"


self.addEventListener("fetch", function (event) {
  event.respondWith(
    caches.match(event.request).then(function (respuesta) {
      return respuesta || fetch(event.request)
    })
  )
})

 

 
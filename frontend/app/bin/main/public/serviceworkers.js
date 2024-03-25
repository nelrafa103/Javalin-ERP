let cacheName = "core" // Whatever name
// Pass all assets here
// This example use a folder named «/core» in the root folder
// It is mandatory to add an icon (Important for mobile users)
 


self.addEventListener("fetch", function(e) {
  e.respondWith(
    caches.match(e.request).then(function(response) {
      return response || fetch(e.request)
    })
  )
})
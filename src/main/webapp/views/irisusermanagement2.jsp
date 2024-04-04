<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Scrolling Images</title>
<style>
    #imageContainer {
        width: 790px;
        height: 155px;
        overflow: hidden;
        border: 1px solid #ddd;
        border-radius: 8px;
        position: relative;
    }
    .scrollingImages {
        display: flex;
        position: absolute;
    }
    .scrollingImages img {
        margin-right: 10px;
        height: 100%;
        flex-shrink: 0;
        object-fit: cover;
        object-position: center;
    }
</style>
</head>
<body>
<div id="imageContainer">
    <div class="scrollingImages">
        <!-- Repeat images here -->
       <img src="data:image/jpeg;base64,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" alt="Image 1">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzz8nHzZ88zs5tbqCM7zF7_tU23IQDa76Jyw&usqp=CAU" alt="Image 2">
        <!-- Repeat images again -->
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        var scrollDuration = 8000; // Adjust scroll duration in milliseconds
        var cloneCount = 10; // Number of times to clone the images
        var $images = $('.scrollingImages img');
        var containerWidth = $('#imageContainer').width(); 
        var totalImages = $images.length;
        var imageWidth = $images.outerWidth(true); // Including margin
        var totalWidth = totalImages * imageWidth;

        // Clone images to ensure continuous loop
        var $cloneImages = $images.clone().addClass('cloned');
        for (var i = 0; i < cloneCount; i++) {
            $('.scrollingImages').append($cloneImages.clone());
        }

        // Update total width to include cloned images
        totalWidth += totalImages * imageWidth * cloneCount;

        // Set total width of container
        $('.scrollingImages').css('width', totalWidth + 'px');

        // Animate scrolling
        function startScrolling() {
            $('.scrollingImages').animate({
                left: -totalWidth
            }, scrollDuration, 'linear', function() {
                // Move first image to the end
                $('.scrollingImages img:first-child').appendTo('.scrollingImages');
                // Reset left position
                $('.scrollingImages').css('left', 0);
                // Restart scrolling
                startScrolling();
            });
        }

        // Start scrolling
        startScrolling();
    });
</script>
</body>
</html>

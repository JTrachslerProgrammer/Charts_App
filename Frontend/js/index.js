document.getElementById('loadPdfButton').addEventListener('click', function() {
    const pdfName = 'LAX-ground.pdf';
    const apiUrl = `http://localhost:8080/api/pdf/${pdfName}`;

    fetch(apiUrl)
        .then(response => response.blob())
        .then(blob => {
            const url = URL.createObjectURL(blob);
            const iframe = document.createElement('iframe');
            iframe.src = url;
            iframe.width = '100%';
            iframe.height = '600px';
            document.getElementById('pdfContainer').appendChild(iframe);
        })
        .catch(error => console.error('Error fetching PDF:', error));
});

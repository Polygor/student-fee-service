# Use the official Nginx image as a parent image
FROM nginx:alpine

# Remove the default Nginx configuration file
RUN rm /etc/nginx/conf.d/default.conf

# Copy the custom Nginx configuration file
COPY nginx.conf /etc/nginx/nginx.conf

# Expose port 9000
EXPOSE 9000

# Start Nginx when the container has provisioned
CMD ["nginx", "-g", "daemon off;"]